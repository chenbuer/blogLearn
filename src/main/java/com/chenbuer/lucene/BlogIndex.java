package com.chenbuer.lucene;


import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.chenbuer.entity.Blog;
import com.chenbuer.util.StringUtil;

public class BlogIndex {

	private Directory dir;
	
	private IndexWriter getWriter() throws Exception {
		dir=FSDirectory.open(Paths.get("D:\\Lucene"));
		Analyzer analyzer=new SmartChineseAnalyzer();
		IndexWriterConfig config=new IndexWriterConfig(analyzer);
		IndexWriter writer=new IndexWriter(dir, config);
		return writer;
	}
	
	/**
	 * ��Ӳ�������
	 * @param blog
	 * @throws Exception
	 */
	public void addIndex(Blog blog) throws Exception{
		IndexWriter writer=null;
		try {
			writer = getWriter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("get writer error");
		}
		Document doc=new Document();
		doc.add(new StringField("id", String.valueOf(blog.getId()), Field.Store.YES));
		doc.add(new StringField("title", blog.getTitle(), Field.Store.YES));
		doc.add(new TextField("content", blog.getContent(), Field.Store.NO));
		try {
			writer.addDocument(doc);
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("writer add doc error");
		}finally {
				writer.close();
		}
	}
	
	/**
	 * ɾ����������
	 * @param blog
	 * @throws Exception
	 */
	public void delIndex(String blogId)throws Exception{
		IndexWriter writer=getWriter();
		writer.deleteDocuments(new Term("id", blogId));
		writer.forceMergeDeletes();//ǿ��ɾ�����������ر���ʱ�򣬲���ÿɾ��һ�ξ�ǿ��merge������Ҫ��ϵͳ���ɲ��ߵ�ʱ��merge
		writer.commit();//ɾ����Ҫcommit����Ȼ��Ҫ��Ч
		writer.close();
	}
	
	/**
	 * �޸Ĳ�������
	 * @param blog
	 * @throws Exception
	 */
	public void updateIndex(Blog blog)throws Exception{
		IndexWriter writer=getWriter();
		Document doc=new Document();
		doc.add(new StringField("id", blog.getId().toString(), Field.Store.YES));
		doc.add(new StringField("title", blog.getTitle(), Field.Store.YES));
		doc.add(new TextField("content", blog.getContent(), Field.Store.NO));
		writer.updateDocument(new Term("id", blog.getId().toString()), doc);
		writer.close();
	}
	
	/**
	 * ��ѯ����
	 * @param q
	 * @return
	 * @throws Exception
	 */
	public List<Blog> searchBlog(String q)throws Exception{
		dir=FSDirectory.open(Paths.get("D:\\Lucene"));
		IndexSearcher is=new IndexSearcher(DirectoryReader.open(dir));
		
		Analyzer analyzer=new SmartChineseAnalyzer();
		//title��ѯ��Query
		QueryParser queryParserTitle=new QueryParser("content", analyzer);
		Query queryTitle=queryParserTitle.parse(q);
		//content��ѯ��Query
		QueryParser queryParserContent=new QueryParser("content",analyzer);
		Query queryContent=queryParserContent.parse(q);
		
		//����������ѯ֮��Ĺ�ϵ
		BooleanQuery.Builder booleanQuery=new BooleanQuery.Builder();
		booleanQuery.add(queryTitle, Occur.SHOULD);
		booleanQuery.add(queryContent, Occur.SHOULD);
		
		TopDocs hits=is.search(booleanQuery.build(), 100);
		
		QueryScorer scorer = new QueryScorer(queryTitle);//ʹ��title�÷ָߵ���ǰ��
		Fragmenter fragmenter = new SimpleSpanFragmenter(scorer); //�÷ָߵ�Ƭ��
		SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color='red'>", "</font></b>");
		Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer); //������ʾ
		highlighter.setTextFragmenter(fragmenter); //���÷ָߵ�Ƭ�����ý�ȥ
		
		List<Blog> blogIndexList = new LinkedList<Blog>(); //������װ��ѯ���Ĳ���
		for(ScoreDoc score : hits.scoreDocs) {
			Document doc = is.doc(score.doc);
			Blog blog = new Blog();
			blog.setId(Integer.parseInt(doc.get("id")));
			blog.setReleaseDateStr(doc.get("releaseDate"));
			String title = doc.get("title");
			String content = doc.get("content");
			if(title != null) {
				TokenStream tokenStream = analyzer.tokenStream("title", new StringReader(title));
				String hTitle = highlighter.getBestFragment(tokenStream, title);
				if(StringUtil.isEmpty(hTitle)) {
					blog.setTitle(title);
				} else {
					blog.setTitle(hTitle);
				}
			}
			if(content != null) {
				TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(content));
				String hContent = highlighter.getBestFragment(tokenStream, content);
				if(StringUtil.isEmpty(hContent)) {
					if(content.length() > 100) { //���û�鵽��content�����ִ���100�Ļ�
						blog.setContent(content.substring(0, 100)); //��ȡ100���ַ�
					} else {
						blog.setContent(content);
					}
				} else {
					blog.setContent(hContent);
				}
			}
			blogIndexList.add(blog);
		}
		
		return blogIndexList;
		
	}
	
}

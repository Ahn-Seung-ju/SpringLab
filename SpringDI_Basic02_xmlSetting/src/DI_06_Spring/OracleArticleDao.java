package DI_06_Spring;

public class OracleArticleDao implements ArticleDao{

	@Override
	public void insert(Article article) {
		System.out.println("Oraclesql 구문 실행");
		
	}

}

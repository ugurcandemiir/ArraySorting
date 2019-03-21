package hw02 ;

public class Book {
 	private String title;
 	private int pages;
 	double[] dimensions = new double[3];
  
  	public Book(String theTitleOfBook, int theNumberOfPages){
    		title = theTitleOfBook;
    		pages = theNumberOfPages;
  	}
  	public String getTitle() {
		return title;
  	}
  	public int getPages() {
		return pages;
	}  
  	

}


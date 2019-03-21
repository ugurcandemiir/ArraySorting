package hw02 ;

public class Library {
 	private Book[] books;

 	public Library(Book b1 , Book b2 ,  Book b3){	
		books = new Book[3];
		books[0] = b1;
		books[1] = b2;
		books[2] = b3;	

 	}
	public void catalog(){
		int i;
		for(i=0;i<books.length;i++) {
			System.out.println("Books " + i + ": " + books[i].getTitle());
		}
	}
	
	public void totalPages(){
		int i;
		int total = 0;
		for(i=0; i<books.length ; i++) {
			total = total + books[i].getPages() ;
		}
		System.out.println("Sum of the pages is " + total);
	}
	
	public void maxPages(){
  		int maxValue = books[0].getPages();
  		for(int i=0 ; i < books.length ; i++){
    			if(books[i].getPages() > maxValue){
	  		maxValue = books[i].getPages();
			}
		}
		System.out.println("The maximum number of pages is " + maxValue);
		
	}
	public void bubbleSortBook() {
		Book tmpBook;
		int b;
		int a;
		for(a=0;a<books.length-1 ; a++) {
			for (b=0 ; b<(books.length-a)-1 ; b++  ){
				if (books[b].getPages()> books[b+1].getPages() ){ 
					tmpBook = books[b] ;
					books[b] = books[b+1] ;
					books[b+1] = tmpBook;	
					}
			}
		}
	}
	
	static public void main(String[] args) {
		System.out.println("====================================");				
		Book b1 = new Book("Hamlet",450);
		Book b2 = new Book("Great Expectation",354);
		Book b3 = new Book("Frankenstein",879);
		Library l1 = new Library(b1,b2,b3);
  		l1.catalog();
		System.out.println("====================================");	
		l1.totalPages();
		System.out.println("====================================");			
		l1.maxPages();
		System.out.println("====================================");		  	
		l1.bubbleSortBook();
		System.out.println("Library is sorting according to pages...");	
		for (int i=0 ; i < l1.books.length ; i++) {
			System.out.println(l1.books[i].getPages() +" " + l1.books[i].getTitle() );
		}
		System.out.println("====================================");	

	}
}

package com.binglian.pojo.VO;

import javax.persistence.Column;

public class BookVO {
	 	private String bookTitle;

	    private String bookImg;

	    private String bookDesc;

	    private String bookAuthor;

		public String getBookTitle() {
			return bookTitle;
		}

		public void setBookTitle(String bookTitle) {
			this.bookTitle = bookTitle;
		}

		public String getBookImg() {
			return bookImg;
		}

		public void setBookImg(String bookImg) {
			this.bookImg = bookImg;
		}

		public String getBookDesc() {
			return bookDesc;
		}

		public void setBookDesc(String bookDesc) {
			this.bookDesc = bookDesc;
		}

		public String getBookAuthor() {
			return bookAuthor;
		}

		public void setBookAuthor(String bookAuthor) {
			this.bookAuthor = bookAuthor;
		}
	    
	    
}

package Classes;

public abstract class Transaction {

		protected double total;
		protected double totalWhithDiscount;
		protected static int transactionNumber;
		
		public double getTotal() {
			return total;
		}
		public void setTotal(double total) {
			this.total = total;
		}
		public double getTotalWhithDiscount() {
			return totalWhithDiscount;
		}
		public void setTotalWhithDiscount(double totalWhithDiscount) {
			this.totalWhithDiscount = totalWhithDiscount;
		}
		public static int getTransactionNumber() {
			return transactionNumber;
		}
		public static void setTransactionNumber(int transactionNumber) {
			Transaction.transactionNumber = transactionNumber;
		}
		
		public void calculateDiscount(){}
		public void calculateDiscount(ShoppingCart shoppingCart){}
		
		@Override
		public String toString() {
			return "Transaction [total=" + total + ", totalWhithDiscount="
					+ totalWhithDiscount + "]";
		}
		
		
		
}

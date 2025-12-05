/**
 * 
 */

/**
 * 
 */
public class ExceptionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 try {
	            int a = 10 / 0; // ArithmeticException
	        } catch (ArithmeticException e) {
		 	// } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        } finally {
	            System.out.println("Finally block always runs.");
	        }

	}

}

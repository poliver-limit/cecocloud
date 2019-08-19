/**
 * 
 */
package es.limit.cecocloud.persist.util;

/**
 * Utilitat per a la generació de sentències SQL INSERT.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class SqlInsertGenerator {

	private static final String INSERT_INTO = "INSERT INTO ";
	private static final String TABLE_NAME = "COMPANYIA";
	private static final String VALUES = " VALUES";
	private static final int NUM_ROWS = 1000;

	public static void main(String[] args) {
		for (int i = 0; i < NUM_ROWS; i++) {
			System.out.println(INSERT_INTO + TABLE_NAME + VALUES + getValues(i));
		}
	}

	private static String getValues(int index) {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(index + 1);
		sb.append(",'");
		String codi = String.format("%06d", index);
		sb.append(codi);
		sb.append("','");
		sb.append("Companyia ");
		sb.append(codi);
		sb.append("',");
		sb.append("0");
		sb.append(")");
		return sb.toString();
	}

}

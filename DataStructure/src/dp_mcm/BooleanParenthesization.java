package dp_mcm;

public class BooleanParenthesization {
	

	public static void main(String[] args) {
		char symbols[] = "TTFT".toCharArray();
		char operators[] = "|&^".toCharArray();
		int n = symbols.length;

		System.out.println(countParenth(symbols, operators, n));
	}
		
	private static int countParenth(char symb[], char oper[], int length) {
		
		int False[][] = new int[length][length];
		int True[][] = new int[length][length];
		
		for (int i = 0; i < length; i++) {
			False[i][i] = (symb[i] == 'F') ? 1 : 0;
			True[i][i] = (symb[i] == 'T') ? 1 : 0;
		}

		for (int gap = 1; gap < length; ++gap) {
			for (int i = 0, j = gap; j < length; ++i, ++j) {
				True[i][j] = False[i][j] = 0;
				for (int g = 0; g < gap; g++) {
					int k = i + g;

					int tik = True[i][k] + False[i][k];
					int tkj = True[k + 1][j] + False[k + 1][j];

					if (oper[k] == '&') {
						True[i][j] += True[i][k] * True[k + 1][j];
						False[i][j] += (tik * tkj - True[i][k] * True[k + 1][j]);
					}
					if (oper[k] == '|') {
						False[i][j] += False[i][k] * False[k + 1][j];
						True[i][j] += (tik * tkj - False[i][k] * False[k + 1][j]);
					}
					if (oper[k] == '^') {
						True[i][j] += False[i][k] * True[k + 1][j] + True[i][k] * False[k + 1][j];
						False[i][j] += True[i][k] * True[k + 1][j] + False[i][k] * False[k + 1][j];
					}
				}
			}
		}
		return True[0][length - 1];
	}
}

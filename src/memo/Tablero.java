/**
 * @author Daniel Alvarez
 * @date   16 de octubre de 2009
 */

package memo;

public class Tablero
{
	private int dim;
	private int[][] M;
	private boolean[][] X;

	public Tablero(int d)
	{
		dim = d;
		M = new int[dim][dim];
		X = new boolean[dim][dim];
	}
	public int getPos(int i, int j)
	{
		return M[i][j];
	}
	public boolean esClic(int i, int j)
	{
		return X[i][j];
	}
	public void clic(int i, int j)
	{
		X[i][j] = !X[i][j];
	}
	public int getDim()
	{
		return dim;
	}
	public boolean esCompleto()
	{
		int c = 0;
		for (int i = 0; i < dim; i++)
		{
			for (int j = 0; j < dim; j++)
			{
				if(X[i][j])
					c++;
			}
		}
		if(c == dim * dim)
			return true;
		return false;
	}
	public void genAleatorio()
	{
		int g = 1;
		for (int i = 0; i < dim; i++)
		{
			for (int j = 0; j < dim; j++)
			{
				M[i][j] = g++;
				if(g == 9)
					g = 1;
			}
		}
		int x, y;
		for (int i = 0; i < dim; i++)
		{
			for (int j = 0; j < dim; j++)
			{
				x = (int) (Math.random() * dim);
				y = (int) (Math.random() * dim);
				int aux = M[i][j];
				M[i][j] = M[x][y];
				M[x][y] = aux;
			}
		}
	}
}

import java.util.ArrayList;

public class JeuDeLaVie 
{
	private boolean[][] tab;

	private ArrayList<boolean[][]> historique;

	private int     vit;
	private int     naisMin;
	private int     naisMax;
	private int     vieMin;
	private int     vieMax;

	protected boolean temps;

	private Frame   frame;

	private Menu menu;

	public JeuDeLaVie()
	{
		this.menu();
	}

	public void menu()
	{
		this.menu = new Menu(this);
	}

	public void parametrage(int vit, int haut, int larg, int naisMin, int naisMax, int vieMin, int vieMax)
	{
		this.menu.dispose();

		this.temps = true;

		if(this.tab == null || this.tab.length != haut || this.tab[0].length != larg)
		{
			this.tab = new boolean[haut][larg];

			for(int cptLig = 0; cptLig < haut; cptLig++)
				for(int cptCol = 0; cptCol < larg; cptCol++)
					this.tab[cptLig][cptCol] = false;
			
			this.historique = new ArrayList<boolean[][]>();
			this.historique.add(this.tab);
		}

		this.vit     = vit;
		this.naisMin = naisMin;
		this.naisMax = naisMax;
		this.vieMin  = vieMin;
		this.vieMax  = vieMax;

		if(this.frame != null)
			this.frame.dispose();
			
		this.frame = new Frame(this,haut,larg);

		this.frame.actualiser(this.tab);

		this.suivant();
	}


	public void revenir()
	{
		
		if(this.historique.size() > 1)
		{
			this.historique.remove(this.historique.size()-1);
			this.tab = this.historique.get(this.historique.size()-1);
			this.frame.actualiser(this.tab);
		}
	}

	public void suivant()
	{
		this.tableauSuivant();
	}

	public void ajout(int lig, int col)
	{
		this.tab[lig][col] = !this.tab[lig][col];
		this.frame.actualiser(this.tab);
	}

	public void tableauSuivant()
	{
		int[][] tabNbV = new int[this.tab.length][this.tab[0].length];

		for(int cptLig = 0; cptLig < this.tab.length; cptLig++)
		{
			for(int cptCol=0;cptCol < this.tab[0].length; cptCol++)
			{
				tabNbV[cptLig][cptCol] = 0;

				if (cptLig != 0 && cptLig != this.tab.length-1 && cptCol != 0 && cptCol != this.tab[0].length-1)
				{
					if (this.tab[cptLig][cptCol-1] == true)
						tabNbV[cptLig][cptCol]++;


					if (this.tab[cptLig][cptCol+1] == true)
						tabNbV[cptLig][cptCol]++;


					if (this.tab[cptLig+1][cptCol] == true)
						tabNbV[cptLig][cptCol]++;


					if (this.tab[cptLig+1][cptCol-1] == true)
						tabNbV[cptLig][cptCol]++;


					if (this.tab[cptLig+1][cptCol+1] == true)
						tabNbV[cptLig][cptCol]++;


					if (this.tab[cptLig-1][cptCol] == true)
						tabNbV[cptLig][cptCol]++;


					if (this.tab[cptLig-1][cptCol-1] == true)
						tabNbV[cptLig][cptCol]++;


					if (this.tab[cptLig-1][cptCol+1] == true)
						tabNbV[cptLig][cptCol]++;
				}
				else
				{
					if (cptLig == 0)
					{
						if(cptCol != 0 && cptCol != this.tab[0].length-1)
						{
							if (this.tab[cptLig][cptCol-1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig][cptCol+1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig+1][cptCol] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig+1][cptCol-1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig+1][cptCol+1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[this.tab.length-1][cptCol] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[this.tab.length-1][cptCol+1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[this.tab.length-1][cptCol+1] == true)
								tabNbV[cptLig][cptCol]++;
						}

						if (cptCol == 0)
						{
							if (this.tab[0][1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[0][this.tab[0].length-1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[1][0] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[1][1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[1][this.tab[0].length-1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[this.tab.length-1][0] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[this.tab.length-1][1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[this.tab.length-1][this.tab[0].length-1] == true)
								tabNbV[cptLig][cptCol]++;
						}

						if (cptCol == this.tab.length-1)
						{
							if (this.tab[0][0] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[0][this.tab[0].length-1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[1][this.tab[0].length-1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[1][0] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[1][this.tab[0].length-2] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[this.tab.length-1][0] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[this.tab.length-1][this.tab[0].length-2] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[this.tab.length-1][this.tab[0].length-1] == true)
								tabNbV[cptLig][cptCol]++;
						}
					}
					if (cptLig == this.tab.length-1)
					{
						if(cptCol != 0 && cptCol != this.tab[0].length-1)
						{
							if (this.tab[cptLig][cptCol-1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig][cptCol+1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[0][cptCol] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[0][cptCol-1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[0][cptCol+1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig-1][cptCol] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig-1][cptCol+1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig-1][cptCol+1] == true)
								tabNbV[cptLig][cptCol]++;
						}
						if (cptCol == 0)
						{
							if (this.tab[0][0] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[0][1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[0][this.tab[0].length-1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[this.tab.length-2][1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[this.tab.length-2][this.tab[0].length-1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[this.tab.length-2][this.tab[0].length-2] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[this.tab.length-1][1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[this.tab.length-1][this.tab[0].length-2] == true)
								tabNbV[cptLig][cptCol]++;
						}
						if (cptCol == this.tab[0].length-1)
						{
							if (this.tab[0][0] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[0][this.tab[0].length-2] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[0][this.tab[0].length-1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[this.tab.length-2][0] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[this.tab.length-2][this.tab[0].length-2] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[this.tab.length-1][0] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[this.tab.length-1][this.tab[0].length-2] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[this.tab.length-1][this.tab[0].length-1] == true)
								tabNbV[cptLig][cptCol]++;
						}
						
					}
					if (cptCol == 0)
					{
						if(cptLig != 0 && cptLig != this.tab.length-1)
						{
							if (this.tab[cptLig][this.tab[0].length-1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig][cptCol+1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig+1][cptCol] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig+1][this.tab[0].length-1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig+1][cptCol+1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig-1][cptCol] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig-1][cptCol+1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig-1][cptCol+1] == true)
								tabNbV[cptLig][cptCol]++;
						}
					}
					if (cptCol == this.tab[0].length-1)
					{
						if(cptLig != 0 && cptLig != this.tab.length-1)
						{
							if (this.tab[cptLig-1][0] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig-1][this.tab[0].length-2] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig-1][this.tab[0].length-1] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig][0] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig][this.tab[0].length-2] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig+1][0] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig+1][this.tab[0].length-2] == true)
								tabNbV[cptLig][cptCol]++;

							if (this.tab[cptLig+1][this.tab[0].length-1] == true)
								tabNbV[cptLig][cptCol]++;
						}
					}
				}
			}

		}

		for(int cptLig = 0; cptLig < this.tab.length; cptLig++)
		{
			for(int cptCol=0;cptCol < this.tab[0].length; cptCol++)
			{
				if ((tabNbV[cptLig][cptCol] >= this.vieMin && tabNbV[cptLig][cptCol] <= this.vieMax && this.tab[cptLig][cptCol] == true) || (tabNbV[cptLig][cptCol] >= this.naisMin && tabNbV[cptLig][cptCol] <= this.naisMax && this.tab[cptLig][cptCol] == false))
					this.tab[cptLig][cptCol]= true;
				else
					this.tab[cptLig][cptCol] = false;
			}
		}

		this.historique.add(this.tab.clone());
		
		this.frame.actualiser(this.tab);
	}
	public static void main(String[] args) 
	{
		new JeuDeLaVie();
	}
}
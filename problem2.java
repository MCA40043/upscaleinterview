class problem2{
	
static int r = 3;
static int c = 5;

static boolean issafe(int i, int j)
{
	if (i >= 0 && i < r && j >= 0 && j < c)
	return true;
		
	return false;
}

static int rotOranges(int v[][])
{
	boolean chng = false;
	int num = 2;
	
	while (true) 
	{
		for(int i = 0; i < r; i++) 
		{
			for(int j = 0; j < c; j++)
			{
				
				if (v[i][j] == num) 
				{
					if (issafe(i + 1, j) && v[i + 1][j] == 1)
					{
						v[i + 1][j] = v[i][j] + 1;
						chng = true;
					}
					if (issafe(i, j + 1) && v[i][j + 1] == 1) 
					{
						v[i][j + 1] = v[i][j] + 1;
						chng = true;
					}
					if (issafe(i - 1, j) && v[i - 1][j] == 1)
					{
						v[i - 1][j] = v[i][j] + 1;
						chng = true;
					}
					if (issafe(i, j - 1) && v[i][j - 1] == 1)
					{
						v[i][j - 1] = v[i][j] + 1;
						chng = true;
					}
				}
			}
		}

		if (!chng)
		break;
			
		chng = false;
		num++;
	}

	for(int i = 0; i < r; i++)
	{
		for(int j = 0; j < c; j++) 
		{
			if (v[i][j] == 1)
			return -1;
		}
	}


	return num - 2;
}


public static void main(String[] args)
{
	int v[][] = { {2, 1, 0, 2, 1}, {0, 0, 1, 2, 1}, {1, 0, 0, 2, 1} };

	System.out.println("time frames:" + rotOranges(v));
                 System.out.println("fresh oranges:" + r);
                 System.out.println("Rotten oranges:" +rotOranges(v));
}
}

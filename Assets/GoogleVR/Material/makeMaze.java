void makeMaze(){
	if (maze == null) {
		maze = new int [rows][columns];
	}
	 for (i = 0; i<rows; i++)  // start with everything being a wall
            for (j = 0; j < columns; j++)
                maze[i][j] = unvisitedCode;//-1
}
int visit(){
	int i = Math.random();
	if (i <= 0.7) 
		return 0;//unblocked		
	else
		return 1;//blocked
}
void make(int row, int column){
	if (maze[row + 1][column] < 0) {
		maze[row + 1][column] = visit();
		make(row + 1, column);
	}
	if (maze[row][column + 1] < 0) {
		maze[row][column + 1] = visit();
		make(row, column + 1);
	}
	if (maze[row - 1][column] < 0) {
		maze[row - 1][column] = visit();
		make(row - 1, column);
	}
	if (maze[row][column - 1] < 0) {
		maze[row][column - 1] = visit();
		make(row, column - 1);
	}
	for (i = 0; i < rows; i++)  // start with everything being a wall
            for (j = 0; j < columns; j++)
            		if (maze[i][j] < 0){
            			make(i,j);
            		}
}
package magicsquare;

import BreezySwing.*;

public class MagicSquareServer {
	public boolean addsUp2x2(double num1, double num2, double constant){
		boolean addsUp = false;
		if(num1 + num2 == constant)
			addsUp = true;
		return addsUp;
	}
	
	public boolean addsUp3x3(double num1, double num2, double num3, double constant){
		boolean addsUp = false;
		if(num1 + num2  + num3 == constant)
			addsUp = true;
		return addsUp;
	}
	
	public boolean addsUp4x4(double num1, double num2, double num3, double num4, double constant){
		boolean addsUp = false;
		if(num1 + num2 + num3 + num4 == constant)
			addsUp = true;
			return addsUp;
		}
	
	public boolean addsUp5x5(double num1, double num2, double num3, double num4, double num5,double constant){
		boolean addsUp = false;
		if(num1 + num2 + num3 + num4  + num5 == constant)
			addsUp = true;
		return addsUp;
	}
	
	public boolean addsUp6x6(double num1, double num2, double num3, double num4, double num5, double num6, double constant){
		boolean addsUp = false;
		if(num1 + num2 + num3 + num4 + num5 + num6 == constant)
			addsUp = true;
		return addsUp;
	}
	
	public boolean addsUp7x7(double num1, double num2, double num3, double num4, double num5, double num6, double num7, double constant){
		boolean addsUp = false;
		if(num1 + num2 + num3 + num4 + num5 + num6 + num7 == constant)
			addsUp = true;
		return addsUp;
	}
	
	public boolean addsUp8x8(double num1, double num2, double num3, double num4, double num5, double num6, double num7, double num8,double constant){
		boolean addsUp = false;
		if(num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 == constant)
			addsUp = true;
		return addsUp;
	}
	public boolean isMagicSquare(DoubleField[][] fields, int size, int constant, int correctNeeded, int correct) {
		boolean isMagicSquare = false;
		if(size == 3) {//3x3
			constant = (int)(size * ((Math.pow(size, 2) + 1) / 2));
			correctNeeded = 8;
			for(int i = 0; i < size; i++) { // rows
					if(addsUp3x3(fields[i][0].getNumber(), fields[i][1].getNumber(), fields[i][2].getNumber(), constant) == true) {
						correct++;
				}
			}
			for(int j = 0; j < size; j++) { // columns
				if(addsUp3x3(fields[0][j].getNumber(), fields[1][j].getNumber(), fields[2][j].getNumber(), constant) == true) {
					correct++;
			}
		}
			if(addsUp3x3(fields[0][0].getNumber(), fields[1][1].getNumber(), fields[2][2].getNumber(), constant) == true)
				correct++;
			if(addsUp3x3(fields[0][2].getNumber(), fields[1][1].getNumber(), fields[2][0].getNumber(), constant))
				correct++;
		}
		
		if(size == 4) { //4x4
			constant = (int)(size * ((Math.pow(size, 2) + 1) / 2));
			correctNeeded = 10;
			for(int i = 0; i < size; i++) { // rows
					if(addsUp4x4(fields[i][0].getNumber(), fields[i][1].getNumber(), fields[i][2].getNumber(), fields[i][3].getNumber(), constant) == true) {
						correct++;
				}
			}
			for(int j = 0; j < size; j++) { // columns
				if(addsUp4x4(fields[0][j].getNumber(), fields[1][j].getNumber(), fields[2][j].getNumber(), fields[3][j].getNumber(), constant) == true) {
					correct++;
			}
		}
			if(addsUp4x4(fields[0][0].getNumber(), fields[1][1].getNumber(), fields[2][2].getNumber(), fields[3][3].getNumber(), constant) == true)
				correct++;
			if(addsUp4x4(fields[0][3].getNumber(), fields[1][2].getNumber(), fields[2][1].getNumber(), fields[3][0].getNumber(), constant))
				correct++;
		}
		
		if(size == 5) {//5x5
			constant = (int)(size * ((Math.pow(size, 2) + 1) / 2));
			correctNeeded = 12;
			for(int i = 0; i < size; i++) { // rows
					if(addsUp5x5(fields[i][0].getNumber(), fields[i][1].getNumber(), fields[i][2].getNumber(), fields[i][3].getNumber(), fields[i][4].getNumber(), constant) == true) {
						correct++;
				}
			}
			for(int j = 0; j < size; j++) { // columns
				if(addsUp5x5(fields[0][j].getNumber(), fields[1][j].getNumber(), fields[2][j].getNumber(), fields[3][j].getNumber(), fields[4][j].getNumber(), constant) == true) {
					correct++;
			}
		}
			if(addsUp5x5(fields[0][0].getNumber(), fields[1][1].getNumber(), fields[2][2].getNumber(), fields[3][3].getNumber(), fields[4][4].getNumber(), constant) == true)
				correct++;
			if(addsUp5x5(fields[0][4].getNumber(), fields[1][3].getNumber(), fields[2][2].getNumber(), fields[3][1].getNumber(), fields[4][0].getNumber(), constant))
				correct++;
		}
		
		if(size == 6) {//6x6
			constant = (int)(size * ((Math.pow(size, 2) + 1) / 2));
			correctNeeded = 14;
			for(int i = 0; i < size; i++) { // rows
					if(addsUp6x6(fields[i][0].getNumber(), fields[i][1].getNumber(), fields[i][2].getNumber(), fields[i][3].getNumber(), fields[i][4].getNumber(), 
							fields[i][5].getNumber(), constant) == true) {
						correct++;
				}
			}
			for(int j = 0; j < size; j++) { // columns
				if(addsUp6x6(fields[0][j].getNumber(), fields[1][j].getNumber(), fields[2][j].getNumber(), fields[3][j].getNumber(), fields[4][j].getNumber(),
						fields[5][j].getNumber(), constant) == true) {
					correct++;
			}
		}
			if(addsUp6x6(fields[0][0].getNumber(), fields[1][1].getNumber(), fields[2][2].getNumber(), fields[3][3].getNumber(), fields[4][4].getNumber(), 
					fields[5][5].getNumber(), constant) == true)
				correct++;
			if(addsUp6x6(fields[0][5].getNumber(), fields[1][4].getNumber(), fields[2][3].getNumber(), fields[3][2].getNumber(), fields[4][1].getNumber(),
					fields[5][0].getNumber(), constant))
				correct++;
		}
		
		if(size == 7) {//7x7
			constant = (int)(size * ((Math.pow(size, 2) + 1) / 2));
			correctNeeded = 16;
			for(int i = 0; i < size; i++) { // rows
					if(addsUp7x7(fields[i][0].getNumber(), fields[i][1].getNumber(), fields[i][2].getNumber(), fields[i][3].getNumber(), fields[i][4].getNumber(), 
							fields[i][5].getNumber(), fields[i][6].getNumber(), constant) == true) {
						correct++;
				}
			}
			for(int j = 0; j < size; j++) { // columns
				if(addsUp7x7(fields[0][j].getNumber(), fields[1][j].getNumber(), fields[2][j].getNumber(), fields[3][j].getNumber(), fields[4][j].getNumber(),
						fields[5][j].getNumber(), fields[6][j].getNumber(), constant) == true) {
					correct++;
			}
		}
			if(addsUp7x7(fields[0][0].getNumber(), fields[1][1].getNumber(), fields[2][2].getNumber(), fields[3][3].getNumber(), fields[4][4].getNumber(), 
					fields[5][5].getNumber(), fields[6][6].getNumber(), constant) == true)
				correct++;
			if(addsUp7x7(fields[0][6].getNumber(), fields[1][5].getNumber(), fields[2][4].getNumber(), fields[3][3].getNumber(), fields[4][2].getNumber(),
					fields[5][1].getNumber(), fields[6][0].getNumber(), constant))
				correct++;
		}
		
		if(size == 8) {//8x8
			constant = (int)(size * ((Math.pow(size, 2) + 1) / 2));
			correctNeeded = 18;
			for(int i = 0; i < size; i++) { // rows
					if(addsUp8x8(fields[i][0].getNumber(), fields[i][1].getNumber(), fields[i][2].getNumber(), fields[i][3].getNumber(), fields[i][4].getNumber(), 
							fields[i][5].getNumber(), fields[i][6].getNumber(), fields[i][7].getNumber(), constant) == true) {
						correct++;
				}
			}
			for(int j = 0; j < size; j++) { // columns
				if(addsUp8x8(fields[0][j].getNumber(), fields[1][j].getNumber(), fields[2][j].getNumber(), fields[3][j].getNumber(), fields[4][j].getNumber(),
						fields[5][j].getNumber(), fields[6][j].getNumber(), fields[7][j].getNumber(), constant) == true) {
					correct++;
			}
		}
			if(addsUp8x8(fields[0][0].getNumber(), fields[1][1].getNumber(), fields[2][2].getNumber(), fields[3][3].getNumber(), fields[4][4].getNumber(), 
					fields[5][5].getNumber(), fields[6][6].getNumber(), fields[7][7].getNumber(), constant) == true)
				correct++;
			if(addsUp8x8(fields[0][7].getNumber(), fields[1][6].getNumber(), fields[2][5].getNumber(), fields[3][4].getNumber(), fields[4][3].getNumber(),
					fields[5][2].getNumber(), fields[6][1].getNumber(), fields[7][0].getNumber(), constant))
				correct++;
		}
		if(correct == correctNeeded) 
			isMagicSquare = true;
		return isMagicSquare;
	}
}

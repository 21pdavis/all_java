package objects;

import java.util.ArrayList;

public class StudentInfo {
	private String name;
	private double homeworkAverage;
	private double finalAverage;
	private ArrayList<Double> testGrades = new ArrayList<Double>();
	private ArrayList<Double> quizGrades = new ArrayList<Double>();
	
	public StudentInfo() {
		name = "";
		homeworkAverage = 0;
		finalAverage = 0;
	}
	
	public StudentInfo(String name, double homeworkAverage, ArrayList<Double> testGrades, ArrayList<Double> quizGrades) {
		this.name = name;
		this.homeworkAverage = homeworkAverage;
		this.testGrades = testGrades;
		this.quizGrades = quizGrades;
		initFinalAverage();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setHomeworkAverage(double homeworkAverage) {
		this.homeworkAverage = homeworkAverage;
	}
	
	public double getHomeworkAverage() {
		return homeworkAverage;
	}
	
	private void initFinalAverage() { // calculate the final average from retrieved info
		double testSum = 0, quizSum = 0;
		
		for(int i = 0; i < testGrades.size(); i++) {
			testSum += testGrades.get(i);
		}
		
		for(int i = 0; i < quizGrades.size(); i++) {
			quizSum += quizGrades.get(i);
		}
		
		finalAverage = Math.round((0.5 * (testSum / testGrades.size()) + 0.3 * (quizSum / quizGrades.size()) + 0.2 * homeworkAverage) * 10) / 10.0;
	}
	
	public double getFinalAverage(){
		return finalAverage;
	}
	
	public String toString() {
		return "Name: " + name + ", " + "Final Average: " + finalAverage;
	}
}
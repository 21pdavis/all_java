package objects;

import java.util.ArrayList;
import java.util.Collections;

public class AllStudents {
	private ArrayList<StudentInfo> allStudents;
	private ArrayList<StudentInfo> gradeSortedStudents;
	private ArrayList<StudentInfo> nameSortedStudents;

	public AllStudents() {
		allStudents = new ArrayList<StudentInfo>();
		gradeSortedStudents = new ArrayList<StudentInfo>();
		nameSortedStudents = new ArrayList<StudentInfo>();
	}

	public void addStudent(String name, double homeworkAverage, ArrayList<Double> tests, ArrayList<Double> quizzes) {
		allStudents.add(new StudentInfo(name, homeworkAverage, tests, quizzes));
		gradeSort();
		nameSort();
	}

	public ArrayList<StudentInfo> getAllStudents() {
		return allStudents;
	}

	public ArrayList<StudentInfo> getGradeSortedStudents() {
		return gradeSortedStudents;
	}

	public ArrayList<StudentInfo> getNameSortedStudents() {
		return nameSortedStudents;
	}

	private void gradeSort() {
		gradeSortedStudents = allStudents;
		int minIndex;
		for (int i = gradeSortedStudents.size() - 1; i > 0; i--) {
			minIndex = 0;
			for (int j = 1; j <= i; j++) {
				if (gradeSortedStudents.get(j).getFinalAverage() < gradeSortedStudents.get(minIndex).getFinalAverage()) {
					minIndex = j;
				}
			}
			Collections.swap(gradeSortedStudents, i, minIndex);
		}
	}

	private void nameSort() {
		nameSortedStudents = allStudents;
		int minIndex;
		for (int i = 0; i < nameSortedStudents.size(); i++) {
			minIndex = i;
			for (int j = i + 1; j < nameSortedStudents.size(); j++) {
				if (nameSortedStudents.get(j).getName().compareTo(nameSortedStudents.get(minIndex).getName()) < 0)
					minIndex = j;
			}
			Collections.swap(nameSortedStudents, i, minIndex);
		}
	}

	public void resetAllStudents() {
		allStudents.clear();
		gradeSortedStudents.clear();
		nameSortedStudents.clear();
	}
}
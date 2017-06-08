package StringRotation;

//O(1) solution
public class BestSolution implements StringRotation {
	@Override
	public boolean stringRotation(String rotWord, String original) {
		return (rotWord + rotWord).contains(original);
	}
}

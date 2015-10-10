import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


public class AuthorIdentify
{
	// returns an InputStream that gets data from the named file
	private static InputStream getFileInputStream(String fileName) throws Exception
	{
		InputStream inputStream;

		try {
			inputStream = new FileInputStream(new File(fileName));
		}
		catch (FileNotFoundException e) {		// no file with this name exists
			inputStream = null;
			throw new Exception("unable to open the file -- " + e.getMessage());
		}
		return inputStream;
	}

	private static void countWordPairs(InputStream is, HashMap<String, Integer> dict)
	{
		Scanner sc = null;	
		String word = null;
		String previousWord = null;

		sc = new Scanner(is);
		word = null;
		previousWord = null;

		while (sc.hasNext())
		{
			word = sc.next();
			if (previousWord != null)
			{
				String keyWord = new String(previousWord + "-" + word);
				if (dict.containsKey(keyWord)) {
					dict.put(keyWord, dict.get(keyWord) + 1);
				}
				else {
					dict.put(keyWord, 1);
				}
			}
			previousWord = word;
		}
		sc.close();
	}

	private static int getCount(HashMap<String, Integer> dict, String firstWord, String secondWord)
	{
		// This gets the count of a word pair based on a hash.
		int count = 0;
		String keyWord = new String(firstWord + "-" + secondWord);
				
		if (dict.containsKey(keyWord)){
			count = dict.get(keyWord);
		}
		
		return(count);		
	}
	
	private static int getScore(HashMap<String, Integer> sample, HashMap<String, Integer> reference){
		// score = for all word pairs in the sample, refScore = refScore + (sampleCount * refCount)
		int score = 0;
		// sampleCount = 	the number of times a particular word pair occurs in the sample document
		int sampleCount = 0;
		// refCount = 		the number of times a particular word pair occurs in the reference document
		int refCount = 0;
		Iterator<String> keySetIterator = sample.keySet().iterator();

		while(keySetIterator.hasNext()) {
			String key = keySetIterator.next();
			String firstWord = new String(key.substring(0, key.indexOf("-")));
			String secondWord = new String(key.substring(key.indexOf("-") + 1, key.length()));
			sampleCount = getCount(sample, firstWord, secondWord);
			//Alternatively
			//sampleCount = sample.get(key);
			refCount = getCount(reference, firstWord, secondWord);
			// Print statement for testing
			//System.out.println(key.toString() + ": " + sample.get(key));
			score += (sampleCount * refCount);
		}
		
		return score;
	}
	
	public static void main(String[] args)
	{
		if (args.length != 4)
		{
			System.out.println("USage: AuthorIdentify <ref1> <ref2> <ref3> <sample>");
			System.exit(1);
		}

		try
		{
			System.out.printf("CS261 - AuthorIdentify - William Brown%n%n");
			// Directory information for testing
			// String cwd = new String();
			// cwd = System.getProperty("user.dir");
			// System.out.printf(cwd + "%n%n");
			
			InputStream ref1 = getFileInputStream(args[0]);
			InputStream ref2 = getFileInputStream(args[1]);
			InputStream ref3 = getFileInputStream(args[2]);
			InputStream samp = getFileInputStream(args[3]);

			// Set of HashMaps to hold values. I decided to use a HashMap because it's faster
			// Than iterating over a ton of lists/arrays
			HashMap<String, Integer> ref1Counts = new HashMap<String, Integer>();
			HashMap<String, Integer> ref2Counts = new HashMap<String, Integer>();
			HashMap<String, Integer> ref3Counts = new HashMap<String, Integer>();
			HashMap<String, Integer> sampCounts = new HashMap<String, Integer>();
			
			countWordPairs(ref1, ref1Counts);
			countWordPairs(ref2, ref2Counts);
			countWordPairs(ref3, ref3Counts);
			countWordPairs(samp, sampCounts);
			
			int score1 = getScore(sampCounts, ref1Counts);
			int score2 = getScore(sampCounts, ref2Counts);
			int score3 = getScore(sampCounts, ref3Counts);

			
			// Pick the reference winner
			String winner = null;
			if (score1 > score2 && score1 > score3)
			{
				winner = args[0];
			}
			if (score2 > score1 && score2 > score3)
			{
				winner = args[1];
			}
			if (score3 > score2 && score3 > score1)
			{
				winner = args[2];
			}
			System.out.println("Score1 (" + args[0] + "): " + score1);
			System.out.println("Score2 (" + args[1] + "): " + score2);
			System.out.println("Score3 (" + args[2] + "): " + score3);
			System.out.println("The sample most closely resembles " + winner);			

		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}
}





package ua.training.task3;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import controller.RegEx;
import controller.ScannerUtil;
import view.GlobalConstants;
import view.View;

/**
 * Unit test for simple App.
 */
public class PhoneBookTest {

	@Test
	public void testRegExName() {

		String wrongdata = "mikhail VLADIMIR 1512515 Fear@gmail.com 0633478412";
		String rightdata = "Dmitriy";

		StringBuilder sb = new StringBuilder();
		sb.append(wrongdata).append(GlobalConstants.SPACE).append(rightdata);

		ByteArrayInputStream in = new ByteArrayInputStream(sb.toString().getBytes());
		System.setIn(in);
		Scanner sc = new Scanner(System.in);

		ScannerUtil scn = new ScannerUtil(sc, new View());

		String actualResult = scn.getStringValueFromScanner(RegEx.NAME);
		String expectedResult = rightdata;

		boolean stringValuesAreThesame = false;
		stringValuesAreThesame = expectedResult.equals(actualResult);

		System.setIn(System.in);

		Assert.assertTrue(stringValuesAreThesame);

	}

	@Test
	public void testRegExPhone() {

		String wrongdata = "mikhail VLADIMIR 1512515 Fear@gmail.com 0633478125412";
		String rightdata = "0668521440";

		StringBuilder sb = new StringBuilder();
		sb.append(wrongdata).append(GlobalConstants.SPACE).append(rightdata);

		ByteArrayInputStream in = new ByteArrayInputStream(sb.toString().getBytes());
		System.setIn(in);
		Scanner sc = new Scanner(System.in);

		ScannerUtil scn = new ScannerUtil(sc, new View());

		String actualResult = scn.getStringValueFromScanner(RegEx.PHONE_NUMBER);
		String expectedResult = rightdata;

		boolean stringValuesAreThesame = false;
		stringValuesAreThesame = expectedResult.equals(actualResult);

		System.setIn(System.in);

		Assert.assertTrue(stringValuesAreThesame);
	}

	@Test
	public void testRegExMail() {

		String wrongdata = "mikhail VLADIMIR 1512515 Fear^gmail.com 0633478412";
		String rightdata = "fear@gmail.com";

		StringBuilder sb = new StringBuilder();
		sb.append(wrongdata).append(GlobalConstants.SPACE).append(rightdata);

		ByteArrayInputStream in = new ByteArrayInputStream(sb.toString().getBytes());
		System.setIn(in);
		Scanner sc = new Scanner(System.in);

		ScannerUtil scn = new ScannerUtil(sc, new View());

		String actualResult = scn.getStringValueFromScanner(RegEx.EMAIL);
		String expectedResult = rightdata;

		boolean stringValuesAreThesame = false;
		stringValuesAreThesame = expectedResult.equals(actualResult);

		System.setIn(System.in);

		Assert.assertTrue(stringValuesAreThesame);

	}

	@Test
	public void testRegExSkype() {

		String wrongdata = "15mikhail 2323VLADIMIR 1512515 242Fear@gmail.com 0633478412";
		String rightdata = "fearformeh";

		StringBuilder sb = new StringBuilder();
		sb.append(wrongdata).append(GlobalConstants.SPACE).append(rightdata);

		ByteArrayInputStream in = new ByteArrayInputStream(sb.toString().getBytes());
		System.setIn(in);
		Scanner sc = new Scanner(System.in);

		ScannerUtil scn = new ScannerUtil(sc, new View());

		String actualResult = scn.getStringValueFromScanner(RegEx.SKYPE);
		String expectedResult = rightdata;

		boolean stringValuesAreThesame = false;
		stringValuesAreThesame = expectedResult.equals(actualResult);

		System.setIn(System.in);

		Assert.assertTrue(stringValuesAreThesame);

	}

}
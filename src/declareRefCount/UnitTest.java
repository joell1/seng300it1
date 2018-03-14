package declareRefCount;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.Test;

public class UnitTest {
private static String BASEDIR = "C:\\Users\\JoelL\\eclipse-workspace\\declareRefCount\\src\\declareRefCount\\testthesefiles";
	@Test
	public void oneArg() {
		String[] args = {"C"};
		assertEquals(0,Entry.EntryRun(args));
	}
	@Test
	public void threeArg() {
		String[] args = {"C","D","Y"};
		assertEquals(0,Entry.EntryRun(args));
	}
	
	@Test
	public void twoArgEntry() {
		String[] args = {BASEDIR, "Entry"};
		assertEquals(1,Entry.EntryRun(args));
	}
	@Test
	public void twoArgString() {
		String[] args = {BASEDIR, "java.lang.String"};
		assertEquals(1,Entry.EntryRun(args));
	}
	@Test
	public void twoArgStringbackslash() {
		String[] args = {BASEDIR+"\\", "java.lang.String"};
		assertEquals(1,Entry.EntryRun(args));
	}
	@Test
	public void twoArgStringwrongDir() {
		String[] args = {BASEDIR+"abc", "java.lang.String"};
		assertEquals(0,Entry.EntryRun(args));
	}
	@Test
	public void EntryMainTest(){
		String[] args = {BASEDIR ,"java.lang.String"};
		Entry.main(args);
	}
	@Test
	public void countFileError() {
		int[] counter = {0,0};
		assertNotNull(Entry.count("Entry",BASEDIR+"abc","Entry",counter));
	}
}

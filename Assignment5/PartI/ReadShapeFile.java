import java.io.*;
import java.util.ArrayList;

import shapes.*;

/* your tasks:
 * create a class called ShapeException
 * createShape should throw a ShapeException
 * in main(), you should catch the ShapeException
 * 
 */
public class ReadShapeFile {

	public static GeometricObject createShape (String shapeName) throws ShapeException {
		
		/* if shapeName is "Circle" return Circle();
		 * if shapeName is "Square" return Square();
		 * if shapeName is "Rectangle" return Rectangle();
		 * if it is not any one of these, it should throw
		 * a ShapeException
		 */
		GeometricObject newObject;
		switch (shapeName) {
			case "Circle":
				newObject = new Circle();
				break;
			case "Square":
				newObject = new Square();
				break;
			case "Rectangle":
				newObject = new Rectangle();
				break;
			default:
				throw new ShapeException(shapeName);
		}
		return newObject;
	}
	
	public static void main(String[] args) {
		ArrayList<GeometricObject> shapeList = new ArrayList<GeometricObject>();
		File f = new File("shapes.txt");
		
		/* create a loop to read the file line-by-line */
		FileReader fr = null;
		try {
			fr = new FileReader(f);
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + e.getMessage());
			System.exit(1);
		}
		BufferedReader in = new BufferedReader(fr);
		String inString = null;

		try{
			inString = in.readLine();
		}
		catch (IOException ioe) {
			System.err.println("IO error reading file: " + ioe.getMessage());
		}
		while (inString != null) {
			try {
				GeometricObject shape = createShape(inString);
				shapeList.add(shape);
			} catch (ShapeException se) {
				System.err.println("Cannot create shape: " + se.getMessage());
			}
			try {
				inString = in.readLine();
			} catch (IOException ioe) {
				System.err.println("IO error reading file: " + ioe.getMessage());
				break;
			}
		}
		System.out.println(shapeList);
	}
}

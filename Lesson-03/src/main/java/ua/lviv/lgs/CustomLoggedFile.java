package ua.lviv.lgs;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class CustomLoggedFile{
	private static Logger LOG = Logger.getLogger(CustomLoggedFile.class);
	
	public static void main(String[] args) {
		DomLog();
	}


public static void BasicLog(){
	BasicConfigurator.configure();
	LOG.trace("Trace");
	LOG.debug("Debug");
	LOG.info("Info");
	LOG.warn("Warn");
	LOG.error("Error");
	LOG.fatal("Fatal");
}
public static void DomLog(){
	DOMConfigurator.configure("loggerConfig.xml");
	LOG.trace("Trace");
	LOG.debug("Debug");
	LOG.info("Info");
	LOG.warn("Warn");
	LOG.error("Error");
	LOG.fatal("Fatal");
}
}
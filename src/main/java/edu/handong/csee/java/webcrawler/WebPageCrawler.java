package edu.handong.csee.java.webcrawler;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class WebPageCrawler {

	String url;
	String directory;
	boolean help;

	public static void main(String[] args) {
		
		WebPageCrawler crawler = new WebPageCrawler();
		crawler.run(args);
	}

	public void run(String[] args) {
		Options options = createOptions();

		if (parseOptions(options, args)) {
			if (help) {
				printHelp(options);
				return;
			}

			URLReader urlReader = new URLReader();
			HTMLCreator htmlCreator = new HTMLCreator();

			String line = urlReader.merger(url);
			htmlCreator.saveAsHTML(directory, line);

			}
		}

	private boolean parseOptions(Options options, String[] args) {
		
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);

			url = cmd.getOptionValue("u");
			directory = cmd.getOptionValue("d");
			help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}


	private Options createOptions() {
		Options options = new Options();

		options.addOption(Option.builder("u")
				.longOpt("url")
				.desc("URL option")
				.hasArg()
				.argName("url name")
				.required()
				.build());
		
		options.addOption(Option.builder("d")
				.longOpt("directory")
				.desc("Directory option")
				.hasArg()
				.argName("directory name")
				.required()
				.build());

		
		options.addOption(Option.builder("h")
				.longOpt("help")
				.desc("Help")
				.build());

		return options;
	}

	private void printHelp(Options options) {

		HelpFormatter formatter = new HelpFormatter();
		
		String header = "CLI based webcrawling program";
		
		String footer = "\nPlease report issues at https://github.com/haileyjamb/WebPageCrawler/issues";
		
		formatter.printHelp("WebPageCrawler", header, options, footer, true);
	}

}

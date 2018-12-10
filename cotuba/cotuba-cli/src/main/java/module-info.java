module cotuba.cli {
	requires commons.cli;
	requires cotuba.core;

	requires spring.context;
	requires spring.beans;
	requires spring.core;

	requires java.sql;
	
	opens cotuba.cli;
}
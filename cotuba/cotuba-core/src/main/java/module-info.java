module cotuba.core {
	exports cotuba.application;
	exports cotuba.plugin;
	exports cotuba.domain;

	requires jsoup;
	requires org.commonmark;

	requires spring.context;
	requires spring.beans;
	requires spring.core;

	uses cotuba.plugin.Tema;
	uses cotuba.plugin.AoFinalizarGeracao;
	uses cotuba.plugin.GeradorEbook;

	opens cotuba.plugin;
	opens cotuba.md;
	opens cotuba.tema;
}
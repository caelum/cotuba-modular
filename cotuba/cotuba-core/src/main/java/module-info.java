module cotuba.core {
	exports cotuba.application;
	exports cotuba.plugin;
	exports cotuba.domain;

	requires jsoup;
	requires org.commonmark;

	uses cotuba.plugin.Tema;
	uses cotuba.plugin.AoFinalizarGeracao;
	uses cotuba.plugin.GeradorEbook;

}
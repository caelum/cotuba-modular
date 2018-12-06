module cotuba.core {
	exports cotuba.application;
	exports cotuba.domain.builder;
	exports cotuba.plugin;
	exports cotuba.tema;
	exports cotuba.domain;
	exports cotuba.md;

	requires jsoup;
	requires org.commonmark;
}
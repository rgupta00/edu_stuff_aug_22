package com.demo;

import org.springframework.batch.item.ItemProcessor;

public class ProductProcessor implements ItemProcessor<Product,Product> {

	@Override
	public Product process(Product item) throws Exception {
		double gst= item.getPrice()*0.3;
		item.setGst(gst);
		return item;
	}

}

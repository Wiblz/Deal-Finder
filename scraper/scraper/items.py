# -*- coding: utf-8 -*-

import scrapy


class ScraperItem(scrapy.Item):
    brand = scrapy.Field()
    price = scrapy.Field()
    price_currency = scrapy.Field()
    model = scrapy.Field()
    available_sizes = scrapy.Field()
    color = scrapy.Field()
    image = scrapy.Field()
    description = scrapy.Field()
    is_discounted = scrapy.Field()
    gender = scrapy.Field()  # m | w | u
    inner_id = scrapy.Field()
    db_category = scrapy.Field()

    resource = scrapy.Field()
    url = scrapy.Field()
    date = scrapy.Field()

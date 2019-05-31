Rally - Bus |Trip Timings Page

# Object Definitions
==================================================================================================================

# Round Trip
div_roundTripTab								css									div[class="tabs"]>div:nth-child(1)

# Oneway Trip
div_onewayTripTab								css									div[class="tabs"]>div:nth-child(2)

# outBound
select_outbound									xpath								(//select[@class="select"])[1]
option_outBound									xpath								(//select[@class="select"])[1]/option[contains(text(),"${option}")]
div_outboundDateField							xpath								(//div[@class="button current-date"])[1]

# return
select_return									xpath								(//select[@class="select"])[2]
option_return									xpath								(//select[@class="select"])[2]/option[contains(text(),"${option}")]
div_returnDateField								xpath								(//div[@class="button current-date"])[2]

# common
btn_dateHeader									css									div[class="editor active"]>div.header>button:nth-of-type(2)
btn_monthHeader									css									div[class="editor active"]>div.header>button:nth-of-type(3)
btn_yearHeader									css									div[class="editor active"]>div.header>button:nth-of-type(4)
btn_date										css									button[class*="day"]:not([class="day other-scope"])>div,button[class*="day chosen"]:not([class="day other-scope"])>div
btn_month										css									button[class*="month"]>div,button[class*="month chosen"]>div
btn_year										css									button[class*="year"],button[class*="year chosen"]
btn_previous									css									div[class="editor active"]>div.header>button[class*="prev"]
btn_next										css									div[class="editor active"]>div.header>button[class*="next"]
div_hourHeading									xpath								(//div[@id="h"])[${option}]
div_minuteHeading								xpath								(//div[@id="m"])[${option}]
div_periodHeading								xpath								(//div[@id="r"])[${option}]
div_hour										css									div[class^="wrapper h"]>div>div[class="editor"]:nth-of-type(1)>div[class="box "],div[class^="wrapper h"]>div>div[class="editor"]:nth-of-type(1)>div[class="box current"]
div_minute										css									div[class^="wrapper m"]>div>div[class="editor"]:nth-of-type(2)>div[class="box "],div[class^="wrapper m"]>div>div[class="editor"]:nth-of-type(2)>div[class="box current"]
div_period										css									div[class^="wrapper r"]>div>div[class="editor"]:nth-of-type(3)>div[class="box "],div[class^="wrapper r"]>div>div[class="editor"]:nth-of-type(3)>div[class="box current"]


# final step
btn_nextAddContact								css									button[class$="button--yellow"][type]:not(disabled)
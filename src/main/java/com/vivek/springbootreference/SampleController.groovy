package com.vivek.springbootreference;

@RestController
class SampleController {

	@RequestMapping("/checkgroovy")
	String home() {
		"Hello World!"
	}

}
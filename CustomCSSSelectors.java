package SeleniumProgs;

public class CustomCSSSelectors {

	public static void main(String[] args)throws Exception {
		
		//1. ID -> htmlTag#id, #id
		//2. CLASS -> htmlTag.className, .className, .className1.className2.className3 (if multiple classes are there), htmlTag.className1.className2.className3 (if multiple classes are there)
		//3. ParentTag > ChildTag
		
		//ul#categories
		//#categories
		//input.username
		//.username
		//input.form-control.private-from_control.login-email
		//input#username.form-control.private-from_control.login-email
		//.form-control.private-from_control.login-email
		
		
		//4. htmlTag[id='value']    input[id="username"]; (1 attribute) or input[id="username"][type="email"]; (2 attributes)
		//5. input[id*="user"]      input[id*=test_] it may be test_123,test_234,test_456
		//6. input[id^="user"]      id starts with user
		//7. input[id$="user"]      id ends with user
		//8. div.private-form__input-wrapper,input#username      "," seperator
		//9.  ul#categories > li     Get all li elements for ul
		//10. ul#categories > li:first-of-type    it will give 1st li element
		//11. ul#categories > li:last-of-type     it will give last li element
		//12. ul#categories > li:nth-of-type(1)   it will move to any random element passed as an parameter
		//13. ul#categories > li:nth-of-type(n)   it will give all li elements
		//14. div.private-form__input-wrapper+div Sibling of an element
		

	}

}

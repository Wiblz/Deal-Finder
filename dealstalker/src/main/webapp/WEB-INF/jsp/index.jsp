<!DOCTYPE html PUBLIC
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Deal Stalker</title>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<s:head />
</head>
<body style="background-image: url('./backgrounds/background.jpg');">
	<div class="container">
		<div class="row">
			<div style="display: flex; flex-direction: column; text-align: center; padding-top: 50px;">
		    <div>
		    	<s:form action="searchItems" style="display: flex; justify-content: space-around; margin: 0 auto; width: 50%; height: 54px; margin-bottom: 50px;">
			        <s:textfield style="display: inline-block; margin: 0 auto; border-radius: 20px; margin-top: 10px; width: 70%; height: 30px; text-align: center; font-size: 20px; color: black;" placeholder="Search" type="text" name="searchString" label="Search" />
		        	<s:submit style="display: inline-block; margin: 0 auto; width: 100px; height: 30px; border-radius: 15px;"/>
		        </s:form>
		    </div>

			<div>
				 <div style="box-sizing: border-box; padding: 7px; height: 40px; text-align: center; width: 200px; border: 2px solid #e5e5e5; margin: 20px auto; border-radius: 20px;">
				 	<a style="font-weight: bold; font-size: 18px; color: black; text-decoration: none;" href="<s:url action="startRegister" />">Sign up</a>
				 </div>
				 <div style="box-sizing: border-box; padding: 7px; height: 40px; text-align: center; width: 200px; border: 2px solid #e5e5e5; margin: 0px auto; border-radius: 20px;">
				 	<a style="font-weight: bold; font-size: 18px; color: black; text-decoration: none;" href="<s:url action="startSignin" />">Sign in</a>
				 </div>
		    </div>


				<div style="display: flex; flex-direction: row; justify-content: space-around; width: 80%; margin: 0 auto; margin-top: 50px;">
			    <s:iterator value="productList">
						<div style="width: 30%; display: flex; flex-direction: row; justify-content: space-around;">
				    	<div style="width: 200px; height: 200px; margin-right: 20px;">
				      		<img style="width: 100%; border: 2px solid #e5e5e5; border-radius: 10px;" src="<s:property value="imageUrl"/>" alt="image" >
				      </div>
				      <div style="display: flex; flex-direction: column; justify-content: space-around;">
                <p style="font-size: 16px; font-weight: bold;"><s:property value="modelName"/></p>
				      	<p style="font-size: 16px; font-weight: bold;"><s:property value="price"/></p>
				      	<p style="font-size: 16px; font-weight: bold;"><s:property value="priceCurrency"/></p>
				      </div>
						</div>
					</s:iterator>
		    </div>
			</div>
		</div>
	</div>
</body>
</html>

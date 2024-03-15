# Author: Ren Taguchi
## CS4520 Mobile App Development
### Assignment 2 : Amazing Products 
Due Wednesday by 9am Points 10 Submitting a file upload File Types zip Available Jan 31 at 9am - Feb 14 at 9am
We need to create a Single Activity Android Application as follows : 
When the user opens the app every time, they see a LoginFragment.

LoginFragment 
It will have following fields : 
Username : to take input from the user for the username.
Password : to take input from the user for password. 
Login button.
All the views will be in center of screen vertically stacked in order : username, password and login button
Clicking the Login button should navigate to the ProductListFragment, only if the username and password matches "admin" and "admin" respectively. If the username or password differs, display a toast message. Make sure to clear the fields before navigation.

ProductListFragment:
Create a fragment named ProductListFragment (PLF). You need to display a list of below mentioned products. 
Each product/item contains the following info
Name
expiry date [optional field] 
price 
type 
Equipment, 
Food
The data a.ka. Product List is given in the starter code below. Convert the data as needed.  
Use Recycler view to display the list of products and use constraint layout for both PLF and for each item in the list.
Download the two jpg images and add to your drawable folder :
FoodLinks to an external site.
EquipmentLinks to an external site.
While displaying product/item,
 If the expiry date is null, hide the view that displays the date.
When the type is Equipment : 
a. Item's background color will be Light RED : #E06666
b. The image displayed for the item will be equipment jpg.
When the type is Food : 
a. Item's background color will be Light Yellow : #FFD965. 
b. The image displayed for the item will be food jpg.
Text Color for all text inside item is #000000
Points to Remember :

Data will be static in the PLF fragment and no api call will be made.
Use sealed classes for product list. This will be your dataset, in your adapter. 
Use a Navigation graph to navigate between fragments.
Make sure - 
When you hit back on PLF fragment, it takes you back to the Login Fragment 
When you hit back on the Login Fragment, the app should close.
Fork the starter code.Links to an external site. Don't push to TA's repo. Starter code has the "necessary" libraries imported to complete the assignment. However, if the student chooses to do it differently, they might need to import missing libraries if prompted.
Make incremental commits. Do no push all code at once. 
Screenshots are added in starter code to help you visualize the fragments.
Submission Guidelines :

Add a readme file to your project :
Provide a link to your github repo. 
Any other information needed to run project. 
Zip your android application and upload it to Canvas.


### Assignment 4 : API Adventures 
Due Friday by 11:59pm Points 10 Submitting a file upload File Types zip Available Mar 1 at 8:35am - Mar 15 at 11:59pm
In this assignment, continue building on assignment 2- Amazing Products. Before we start, we will make sure to amend our assignment 2 as per TA feedback.

In this assignment, Instead of the static dataset, we need to fetch the data from a given api. 

Api details : 

1. Base URL : https://kgtttq6tg9.execute-api.us-east-2.amazonaws.com/

2. End Point with optional query : page number:  /prod  &  /?page=3

3. Sample Json Response :  HereLinks to an external site. 


Api will work as follows : 

1. It may return a list of products based on page number. If no page number is specified, it will return the first 30 products. Page number is optional. 

2. It will be successful but return no products. 


Points to remember :

Use Recyclerview, MVVM, livedata & constraint layouts wherever applicable.  
Data should be loaded on when the user navigates to the Product list fragment. Load data using retrofit and coroutines. 
For Loading data : 
While the data is loading, the user should see an infinite progress bar. 
On success, present it to the UI and save it to the database. 
If api returns 0-zero results, display a message on screen “No products available”.
Json can have repeated products.This should not be shown on UI.
Products in json can have empty or missing data. This should not be shown on UI.
When offline, data should be fetched from the database if available and displayed on UI.
 

Bonus points (2 points) : Implement pagination using optional page parameters. This can be applied to any assignment.


Starter Project

Please copy the dependencies from the starter projectLinks to an external site. into your assignment 2 gradle file. 

Submission Guidelines :

Add a readme file to your project :
Provide a link to your github repo. 
Any other information needed to run project. 
Zip your android application and upload it to Canvas.

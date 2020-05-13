# Lab + Homework

Given the basic code in the start point there are classes and JpaRepositories for a whisky tracker, your task for this lab is to complete the custom queries and connected them to appropriate RESTful endpoints.



**Whisky**

- `name` - the name of that individual whisky often uses the name of the distillery. An example is "The Glendronach - Revival" which is from "Glendronach" distillery
- `distillery` - the distillery object that it's related to
- `year` - the year edition that the whisky was released/ bottled. The year is not a way of determining the age.
- `age` - how long the whisky in the bottle was matured for before bottling

**Distillery**

- `name` - The name of the whisky distillery.
- `region` - The region of scotland where the whisky is from. These are one of either {**Lowlands**, **Speyside**, **Highlands**, **Islay**, **Campbelltown**, **Island** }
- `whiskys` - the list of related whiskies tracked against that distillery

## Task

**Custom Queries + REST** Write each of the following queries and connect them to an appropriate controller:

### MVP
  * Get all the whiskies for a particular year
  * Get all the distilleries for a particular region
  * Get all the whisky from a particular distillery that's a specific age
  
###  Extensions
  * Get all the whisky from a particular region 
  * Get distilleries that have whiskies that are 12 years old 
  * Get all the whiskies that contain "Glen"
  * Get all the distilleries that have whisky names that begin with "The"
  * Get all the whiskies that begin with "The"

### Further extension

* All CRUD functionality across all routes. GET POST PUT and DELETE.




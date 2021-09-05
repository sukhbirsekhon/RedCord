# RedCord

## Introduction  


RedCord is a public messaging system that allows users to search through topics, post messages in a topic, and comment on current messages posted. User’s can edit, and delete any post or comment submitted by their account and interact with other posts by liking or disliking the post.

The user’s posts, comments and likes/dislikes will be added to the user’s records which can be later be viewed under the user’s history. 

---
## Storyboard  

[Story Board](https://projects.invisionapp.com/prototype/ckasgvpt700kyob01x4gv0q6e/play)

![ProloggerStoryBoard2_6-9-20](https://user-images.githubusercontent.com/63562613/84225944-714b1980-aaae-11ea-948d-c007674acc25.JPG)

---
## Requirements  
#### Scenario  

1. As a person who likes to connect with others on social media, I want to be able to post messages publicly so that I can connect with others with similar interests.

#### Example  

1.1 **Given** 
<br/>
**When** 
<br/>
**Then** 
<br/>  

1.2 **Given** 
<br/>
**When** 
<br/>
**Then** 
<br/>  

1.3 **Given** 
<br/>
**When** 
<br/>
**Then** 
<br/>  

---
#### Scenario  

2. As a person who has questions that I would like to have answered, I want to be able to ask on a public forum so that I can get an answer or pointed in a right direction for the answer. 

#### Example  

2.1 **Given** 
<br/>
**When** 
<br/>
**Then** 
<br/>  

2.2 **Given**
<br/>
**When**
<br/>
**Then**
<br/>  

2.3 **Given**
<br/>
**When**
<br/>
**Then**
<br/>  

---  
#### Scenario  

3. As a person who likes to discover new things that I am not normally exposed to, I want to be able to search a public forum so that I can learn of things I did not know of before.

#### Example  

3.1 **Given** 
<br/>
**When** 
<br/>
**Then** 
<br/>  

3.2 **Given** 
<br/>
**When** 
<br/>
**Then** 
<br/>  

---   
#### Scenario  

4. As a person who would like to share experience or knowledge that I have gained, I want to be able to comment or post to a public forum so that I can assist others their quest for knowledge.

#### Example  

4.1 **Given** 
<br/>
**When** 
<br/>
**Then** 
<br/>  

4.2 **Given** 
<br/>
**When** 
<br/>
**Then** 
<br/>  

4.3 **Given** 
<br/>
**When** 
<br/>
**Then** 
<br/>  

4.4 **Given** 
<br/>
**When** 
<br/>
**Then** 
<br/>  

---  
#### Scenario  

5. As a person who likes social media for entertainment, I want to be able to browse through posts and be able to comment, and like/dislike posts so that I may enjoy the experience of communicating with others through social media.

#### Example  

5.1 **Given** 
<br/>
**When** 
<br/>
**Then** 
<br/>  

5.2 **Given** 
<br/>
**When** 
<br/>
**Then** 
<br/>  

5.3 **Given** 
<br/>
**When** 
<br/>
**Then** 
<br/>  

5.4 **Given** 
<br/>
**When** 
<br/>
**Then** 
<br/>  

---
## Class Diagram  

![Prologger_UML_Diagram-ForFinalReview](https://user-images.githubusercontent.com/63562613/83973842-0e436200-a8b7-11ea-901c-38bb967423ce.jpg)

### Class Diagram Description  

**MainActivity:**  The first screen the user sees. This will have a list of tasks that were logged or that are to be completed.  

**RetrofitLogInstance:**  Bootstrap class required for Retrofit.   

**ContactsDetailActivity:**  A screen that shows the details of the user contacts.  

**MapDetailActivity:**  A section that handles Map activities.  

**AboutDetailActivity:**  A section that handles About activities.  

**Log:**  Noun class that represents the log.  

**Map:**  Noun class that represents a Map task. 

**Contacts:**  Noun class that represents a contact.  

**AboutDetails:**  Noun class that represents About software and company information.  

**ILogDao:**  Interface for Retrofit to find and parse log data.  

**AppContacts:**  Internal app for Contacts.  

**IMapDAO:**  Internal App for Google Maps.  

---
## JSON Schema
> {
>  "type" : "object",
>  "properties" : {
>    "name" : {
>      "type" : "string"
>    },
>    "age" : {
>      "type" : "integer"
>    }
>  }
> }

---
## Team Members and Roles  

Tyler Hitchner - Business Logic/Persistence Specialist
<br/>
Danielle Maddux - Product Owner/Scrum Master
<br/>
Rohan Patel - UI Speicalist
<br/>
Sukhbir Sekhon - DevOps/GitHub Administrator
<br/>

---
## Weekly Meeting  

Tuesdays at 9:00 PM and Thursdays at 10:00 PM. Use Microsoft Teams:
<br/>
Meeting Information Meeting link:
<br/>
https://teams.microsoft.com/l/meetup-join/19%3ameeting_MDQ5ZWQzYmQtYTEwOS00YjQ1LWFhZWQtNTczYmRlZWFjMTVl%40thread.v2/0?context=%7b%22Tid%22%3a%22f5222e6c-5fc6-48eb-8f03-73db18203b63%22%2c%22Oid%22%3a%22677a8abf-57d8-44bb-af5e-78efb1341f8a%22%7d
<br/>


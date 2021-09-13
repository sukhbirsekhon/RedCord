# RedCord

## Introduction  


RedCord is a public messaging system that allows users to search through topics, post messages in a topic, and comment on current messages posted. User’s can edit, and delete any post or comment submitted by their account and interact with other posts by liking or disliking the post.

The user’s posts, comments and likes/dislikes will be added to the user’s records which can be later be viewed under the user’s history. 

---
## Storyboard  

[Story Board](https://projects.invisionapp.com/prototype/cktashbi600d4pg019y0hc45x/play)



---
## Requirements  
#### Scenario  

1. As a person who likes to connect with others on social media, I want to be able to post messages publicly so that I can connect with others with similar interests.

#### Example  

1.1 **Given** a topic is selected
<br/>
**Given** an account is created and logged into
<br/>
**When** clicking on create a new post
<br/>
**Then** a section opens allowing text to be written in and submitted
<br/>  

1.2 **Given** a topic is selected
<br/>
**Given** an account is created and logged into
<br/>
**Given** the create a new post button was clicked
<br/>
**When** pressing the submit button
<br/>
**When** text area is empty
<br/>
**Then** warning that no text was entered and post not submitted
<br/>  

1.3 **Given** a topic is selected
<br/>
**Given** an account is created and logged into
<br/>
**Given** the create a new post button was clicked
<br/>
**When** pressing the submit button
<br/>
**When** text area is valid
<br/>
**Then** post submits and displays under topic
<br/>  

---
#### Scenario  

2. As a person who has questions that I would like to have answered, I want to be able to ask on a public forum so that I can get an answer or pointed in a right direction for the answer. 

#### Example  

2.1 **Given** posts are currently available
<br/>
**When** searching for keywords for question
<br/>
**Then** provides list of posts that are similar to keyword search
<br/>  

2.2 **Given** an account is created and logged into
<br/>
**When** clicking on create a new post button
<br/>
**Then** type question into text area and press submit
<br/>  

2.3 **Given** an account is created and logged into
<br/>
**When** a post for a question was submitted
<br/>
**Then** other logged in users may comment on post
<br/>  

---  
#### Scenario  

3. As a person who likes to discover new things that I am not normally exposed to, I want to be able to search a public forum so that I can learn of things I did not know of before.

#### Example  

3.1 **Given** posts are currently available
<br/>
**When** clicking on a topic
<br/>
**Then** I can look through posts with various information
<br/>  

3.2 **Given** posts are currently available
<br/>
**When** selecting all posts
<br/>
**Then** provides list of posts default sorted by newest
<br/> 

---   
#### Scenario  

4. As a person who would like to share experience or knowledge that I have gained, I want to be able to comment or post to a public forum so that I can assist others their quest for knowledge.

#### Example  

4.1 **Given** an account is created and logged into
<br/>
**When** clicking on create a new post button
<br/>
**Then** type information into text area and press submit
<br/>  

4.2 **Given** an account is created and logged into
<br/>
**When** a post for a question was submitted
<br/>
**Then** I can comment on post
<br/>  

---  
#### Scenario  

5. As a person who likes social media for entertainment, I want to be able to browse through posts and be able to comment, and like/dislike posts so that I may enjoy the experience of communicating with others through social media.

#### Example  

5.1 **Given** posts are currently available
<br/>
**When** selecting all posts
<br/>
**Then** provides list of posts default sorted by newest
<br/> 

5.2 **Given** posts are currently available
<br/>
**When** clicking on a topic
<br/>
**Then** I can look through posts with various information
<br/>  

5.3 **Given** an account is created and logged into
<br/>
**When** a post was submitted I wish to comment on
<br/>
**Then** I can comment on the post
<br/>  

5.4 **Given** an account is created and logged into
<br/>
**When** I click on the like or dislike button
<br/>
**Then** the like/dislike number will increase and be associated with my account
<br/>  

---
## Class Diagram  

![redcordService](https://user-images.githubusercontent.com/54546773/133164792-fffd0052-9d75-470a-aeaa-2050c9eb60b9.png)
![redcordDAO DTO](https://user-images.githubusercontent.com/54546773/133164793-69d65734-8e11-4625-a214-4987fe9eb892.png)
![redcordUI](https://user-images.githubusercontent.com/54546773/133164795-0e47286f-348d-4667-8f48-730bc6c56531.png)

### Class Diagram Description  

**MainActivity:**  The first screen the user sees. This will have a list of posts and topics that users may browse through and read.  

**Message:**  Noun class that represents a posted message.  

**Topic:**  Noun class that represents a topic.  

**IEventDAO:** Interface to parse event JSON  

**ITopicsDAO:** Interface to parse topic JSON  

**IMessageDAO:** Interface to parse message JSON  

---
## JSON Schema
>{
>  "type" : "object",
>  "properties" : {
>    "eventID" : {
>      "type" : "integer"
>    },
>    "topic" : {
>      "type" : "string"
>    },
>    "message" : {
>      "type" : "string"
>    },
>    "messageID" : {
>      "type" : "integer"
>    },
>    "topicID" : {
>      "type" : "integer"
>    },
>    "dateTime" : {
>      "type" : "object",
>      "properties" : {
>        "timezoneOffset" : {
>          "type" : "integer"
>        },
>        "day" : {
>          "type" : "integer"
>        },
>        "hours" : {
>          "type" : "integer"
>        },
>        "minutes" : {
>          "type" : "integer"
>        },
>        "year" : {
>          "type" : "integer"
>        },
>        "time" : {
>          "type" : "integer"
>        },
>        "seconds" : {
>          "type" : "integer"
>        },
>        "date" : {
>          "type" : "integer"
>        },
>        "month" : {
>          "type" : "integer"
>        }
>      }
>    }
>  }
>}

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


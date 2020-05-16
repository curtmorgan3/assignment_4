CREATE DATABASE paper_reviews;

USE paper_reviews;

CREATE TABLE reviewer (
  emailAddress VARCHAR(45) NOT NULL,
  firstName VARCHAR(45) NULL,
  authorFeedback VARCHAR(45) NULL,
  lastName VARCHAR(45) NULL,
  commiteeFeedback VARCHAR(45) NULL,
  phoneNumber VARCHAR(45) NULL,
  affiliation VARCHAR(45) NULL,
  PRIMARY KEY (emailAddress));

CREATE TABLE topic (
  id INT NOT NULL,
  topicName VARCHAR(45) NULL,
  PRIMARY KEY (id));

CREATE TABLE review (
  id INT NOT NULL,
  recommendation VARCHAR(45) NULL,
  meritScore VARCHAR(45) NULL,
  paperId INT NULL,
  readabilityScore VARCHAR(45) NULL,
  reviewerId INT NULL,
  originalityScore VARCHAR(45) NULL,
  relevanceScore VARCHAR(45) NULL,
  PRIMARY KEY (id));


CREATE TABLE author (
  emailAddress VARCHAR(45) NOT NULL,
  firstName VARCHAR(45) NULL,
  lastName VARCHAR(45) NULL,
  PRIMARY KEY (emailAddress));

CREATE TABLE paper (
  id INT NOT NULL,
  title VARCHAR(45) NULL,
  abstract VARCHAR(45) NULL,
  fileN VARCHAR(45) NULL,
  authorEmail VARCHAR(45) NULL,
  PRIMARY KEY (id));


INSERT INTO author 
  (FirstName, LastName, emailAddress) 
  VALUES
  ('Stephen', 'King', 'sking@gmail.com')
;
INSERT INTO author 
  (FirstName, LastName, emailAddress) 
  VALUES
  ('John', 'Scalzi', 'jscalzi@gmail.com')
;
INSERT INTO author 
  (FirstName, LastName, emailAddress) 
  VALUES
  ('Maya', 'Angelou', 'mangelou@gmail.com')
;
INSERT INTO author 
  (FirstName, LastName, emailAddress) 
  VALUES
  ('Dean', 'Koontz', 'dkoontz@gmail.com')
;

INSERT INTO reviewer
  (FirstName, LastName, emailAddress, authorFeedback, commiteeFeedback, phoneNumber, affiliation) 
  VALUES
  ('John', 'Hamm', 'jHamm@gmail.com', 'blah', 'nah', '999-999-9999', 'rebels')
;

INSERT INTO reviewer
  (FirstName, LastName, emailAddress, authorFeedback, commiteeFeedback, phoneNumber, affiliation) 
  VALUES
  ('Luke', 'Skywalker', 'luke@gmail.com', 'blah', 'nah', '999-999-9999', 'rebels')
;

INSERT INTO reviewer
  (FirstName, LastName, emailAddress, authorFeedback, commiteeFeedback, phoneNumber, affiliation) 
  VALUES
  ('Darth', 'Vader', 'vader@gmail.com', 'blah', 'nah', '999-999-9999', 'empire')
;

INSERT INTO topic
  (id, topicName)
  VALUES 
  (1, 'Street Fighting')
;

INSERT INTO topic
  (id, topicName)
  VALUES 
  (2, 'Survival')
;

INSERT INTO paper
  (id, title, fileN, abstract, authorEmail)
  VALUES
  (1, 'A Long Way Home', 'wayHome.txt', ' the middle of text', 'sking@gmail.com')
;

INSERT INTO paper
  (id, title, fileN, abstract, authorEmail)
  VALUES
  (2, 'This way comes.', 'thisWay.txt', 'rnet. It uses a', 'dkoontz@gmail.com')
;

INSERT INTO paper
  (id, title, fileN, abstract, authorEmail)
  VALUES
  (3, 'A Long Way Home', 'wayHome.txt', 'y of over 200', 'jscalzi@gmail.com')
;

INSERT INTO review
  (id, paperId, reviewerId, readabilityScore, recommendation, meritScore, originalityScore, relevanceScore)
  VALUES
  (1, 1, 1, '5/5', 'absolutely', '8/10', '10/10', '5/5')
;

INSERT INTO review
  (id, paperId, reviewerId, readabilityScore, recommendation, meritScore, originalityScore, relevanceScore)
  VALUES
  (2, 2, 2, '5/5', 'absolutely', '8/10', '10/10', '5/5')
;

INSERT INTO review
  (id, paperId, reviewerId, readabilityScore, recommendation, meritScore, originalityScore, relevanceScore)
  VALUES
  (3, 3, 3, '5/5', 'absolutely', '8/10', '10/10', '5/5')
;
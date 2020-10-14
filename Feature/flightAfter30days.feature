Feature: Book a flight after 30 days from current day and get number of 1-stop flights and the minimum price for that day.

Scenario: Book a flight after 30 days from current day and get number of 1-stop flights and the minimum price for that day.
Given Navigate to Make My trip Website
And Click Flight Panel
When Calculate Date
And Click Date
Then User Navigated to Flight Page
And User gets total number of 1-Stop Flights
And User gets minimum cost for 1-Stop Flights

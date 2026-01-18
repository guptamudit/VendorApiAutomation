Feature: Retrieve Vendor Information using vendor id

Scenario: Retrieve vendor information using vendor id
Given: The user Initiate a GET request to vendor URL
When: The user fetches the VendorName from the response
Then: Validate that the Vendor Name is IBM and status code is 200

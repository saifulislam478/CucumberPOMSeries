Feature: Contach Us features
Scenario Outline: Contact Us scenario with different set of data
Given User navigate to contact us page
When usr file the form from given sheetname "<SheetName>"  and rownumber <RowNumber>
And Tick on checkbox
And user click on send button
Then it shows a successful message "Thanks for contacting us! We will be in touch with you shortly."

Examples: 
|SheetName|RowNumber|
|contactus|0|
|contactus|1|
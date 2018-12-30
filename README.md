# AutomationExercise

Maven profile to run the test suite in BDD:

clean integration-test -PchromeProfile -Dcucumber.options=src/test/resources/com/automation/test/features_ui/OrderBooking.feature -Dselenium.url=http://localhost:4444/wd/hub

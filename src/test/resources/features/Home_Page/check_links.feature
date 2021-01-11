Feature: Check Webpage URL's and their response status

  Scenario: Check if the page's elements are reachable
    Given Yigit, an existing customer navigates to application home page
    Then Check Butik page "https://www.trendyol.com/butik/liste/erkek" links and their responses
$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("GoogleFeelingLucky.feature");
formatter.feature({
  "line": 1,
  "name": "Google Feeling Lucky",
  "description": "",
  "id": "google-feeling-lucky",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 3,
      "value": "#Without Example Keyword"
    },
    {
      "line": 4,
      "value": "#Scenario: Google Feeling Lucky Page"
    },
    {
      "line": 5,
      "value": "#"
    },
    {
      "line": 6,
      "value": "#Given User is on google page"
    },
    {
      "line": 7,
      "value": "#When User enters \"Jaffar Sadhik\""
    },
    {
      "line": 8,
      "value": "#And User clicks the search button"
    },
    {
      "line": 9,
      "value": "#Then User able to search the data"
    },
    {
      "line": 12,
      "value": "#With Example Keyword"
    }
  ],
  "line": 14,
  "name": "Google Feeling Lucky Page",
  "description": "",
  "id": "google-feeling-lucky;google-feeling-lucky-page",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 13,
      "name": "@GFeeling"
    },
    {
      "line": 13,
      "name": "@Google"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "User is on google page",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "User enters \"\u003ctext\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "User clicks the I\u0027m Feeling Lucky button",
  "keyword": "And "
});
formatter.examples({
  "line": 21,
  "name": "",
  "description": "",
  "id": "google-feeling-lucky;google-feeling-lucky-page;",
  "rows": [
    {
      "cells": [
        "text"
      ],
      "line": 22,
      "id": "google-feeling-lucky;google-feeling-lucky-page;;1"
    },
    {
      "cells": [
        "Jaffar Sadhik"
      ],
      "line": 23,
      "id": "google-feeling-lucky;google-feeling-lucky-page;;2"
    },
    {
      "cells": [
        "Sadhik"
      ],
      "line": 24,
      "id": "google-feeling-lucky;google-feeling-lucky-page;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 33800013,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Google Feeling Lucky Page",
  "description": "",
  "id": "google-feeling-lucky;google-feeling-lucky-page;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 13,
      "name": "@GFeeling"
    },
    {
      "line": 13,
      "name": "@Google"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "User is on google page",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "User enters \"Jaffar Sadhik\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "User clicks the I\u0027m Feeling Lucky button",
  "keyword": "And "
});
formatter.match({
  "location": "GoogleSearch.user_is_on_google_page()"
});
formatter.result({
  "duration": 41326847685,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Jaffar Sadhik",
      "offset": 13
    }
  ],
  "location": "GoogleSearch.user_enters(String)"
});
formatter.result({
  "duration": 1189232611,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSearch.user_clicks_the_I_m_Feeling_Lucky_button()"
});
formatter.result({
  "duration": 15351103892,
  "status": "passed"
});
formatter.after({
  "duration": 210656,
  "status": "passed"
});
formatter.before({
  "duration": 225703,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Google Feeling Lucky Page",
  "description": "",
  "id": "google-feeling-lucky;google-feeling-lucky-page;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 13,
      "name": "@GFeeling"
    },
    {
      "line": 13,
      "name": "@Google"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "User is on google page",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "User enters \"Sadhik\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "User clicks the I\u0027m Feeling Lucky button",
  "keyword": "And "
});
formatter.match({
  "location": "GoogleSearch.user_is_on_google_page()"
});
formatter.result({
  "duration": 5832980645,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sadhik",
      "offset": 13
    }
  ],
  "location": "GoogleSearch.user_enters(String)"
});
formatter.result({
  "duration": 310458929,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSearch.user_clicks_the_I_m_Feeling_Lucky_button()"
});
formatter.result({
  "duration": 15421735860,
  "status": "passed"
});
formatter.after({
  "duration": 201765,
  "status": "passed"
});
formatter.uri("GoogleSearch.feature");
formatter.feature({
  "line": 1,
  "name": "Google Search",
  "description": "",
  "id": "google-search",
  "keyword": "Feature"
});
formatter.before({
  "duration": 322824,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 3,
      "value": "#Without Example Keyword"
    },
    {
      "line": 4,
      "value": "#Scenario: Google Page"
    },
    {
      "line": 5,
      "value": "#"
    },
    {
      "line": 6,
      "value": "#Given User is on google page"
    },
    {
      "line": 7,
      "value": "#When User enters \"Jaffar Sadhik\""
    },
    {
      "line": 8,
      "value": "#And User clicks the search button"
    },
    {
      "line": 9,
      "value": "#Then User able to search the data"
    },
    {
      "line": 12,
      "value": "#With Example Keyword"
    }
  ],
  "line": 14,
  "name": "Google Search Page",
  "description": "",
  "id": "google-search;google-search-page",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 13,
      "name": "@Gsearch"
    },
    {
      "line": 13,
      "name": "@Google"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "User is on google page",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "User enters text",
  "rows": [
    {
      "cells": [
        "Jaffar Sadhik"
      ],
      "line": 18
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "User clicks the search button",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "User able to search the text",
  "rows": [
    {
      "cells": [
        "Jaffar Sadhik"
      ],
      "line": 21
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "GoogleSearch.user_is_on_google_page()"
});
formatter.result({
  "duration": 4381750222,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSearch.user_enters_text(DataTable)"
});
formatter.result({
  "duration": 456648656,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSearch.user_clicks_the_search_button()"
});
formatter.result({
  "duration": 7335278025,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSearch.user_able_to_search_the_text(DataTable)"
});
formatter.result({
  "duration": 2263166678,
  "status": "passed"
});
formatter.after({
  "duration": 263320,
  "status": "passed"
});
});
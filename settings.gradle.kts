rootProject.name = "Weather Forecast"

include(":app")
include(":model")
include(":list:data:impl", ":list:model")
include(":search:model", ":search:data:impl", ":search:viewModel")

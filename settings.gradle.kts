rootProject.name = "Weather Forecast"

include(":app", ":app:di", ":app:db:impl")
include(":model")
include(":list:data:impl", ":list:model")
include(":search:model", ":search:data:impl", ":search:viewModel", ":search:ui", ":search:di")

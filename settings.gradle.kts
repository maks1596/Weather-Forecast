rootProject.name = "Weather Forecast"

include(":app", ":app:di", ":app:db:impl")
include(":model")
include(":list:model", ":list:data:impl", ":list:viewModel", ":list:ui", ":list:di")
include(":search:model", ":search:data:impl", ":search:viewModel", ":search:ui", ":search:di")

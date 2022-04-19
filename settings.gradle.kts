rootProject.name = "Weather Forecast"

include(":app")
include(":app:di")
include(":model")
include(":list:data:impl", ":list:model")
include(":search:model", ":search:data:impl", ":search:viewModel", ":search:ui", ":search:di")

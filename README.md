This repository contains an example of a working gesture handler for HgLauncher. You can fork this repository to start your own gesture handler.

## What is a gesture handler?

A gesture handler is an extension of HgLauncher (and other similar launchers) able to execute a task per the direction of gesture the launcher broadcasts. This allows further customisations for the launcher's gesture actions without burdening the launcher with the extra line of codes and permissions, which may be not beneficial for the launcher.

## Isn't this basically just launching an app?

Yes! A gesture handler goal is not limited to consolidating various common actions (opening status bar, locking the screen, etc.); the decision for what your gesture handler should do is up to you.

## Which launcher does this work in?

Any launcher that can send gesture directions in an enumerated integer. All gesture handler will only support a limited set of actions, [as defined here](https://github.com/F4uzan/SampleHandler/blob/master/app/src/main/java/mono/hg/samplehandler/GestureHandler.java#L54). If your launcher supports more gesture directions, then those extra actions may not be received or processed by the gesture handler — unless otherwise specified.

## How can I implement this in my launcher?

Simple! You only need to broadcast your gesture directions to the gesture handler. An example of this can be found in HgLauncher's Utils class around [this line of code](https://github.com/F4uzan/HgLauncher/blob/master/app/src/main/java/mono/hg/utils/Utils.java#L205).

It boils down to:
1. Passing the direction as an int.
2. Sending said int-represented direction to the handler.

The handler should then execute an action based on the direction it receives.
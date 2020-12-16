About the project
==============================
This is a simple mod followed by a tutorial from TechnoVision <https://github.com/TechnoVisionDev> to get started with the forge api and a decent feeling for the overall minecraft modding.\
All credit goes to him, big thanks to his great contribution!

What has been implemented
==============================
* Randomly generated `Blood Ore` around the map
* They can be smelted to get `Blood ingot`
* Blood - Tools, armor and weapons
    * Currently, they all have extremely high damage.
* Food item called `Super apple` that is extremely healthy for you and gives you a lot of positive buffs.

How download/play the mod only
==============================
Step1: Download the jar file from MinecraftModTesting/build/libs/\
* Currently, its name is `modid_1.0.jar`

Step2: Paste the jar file into your Minecraft mods folder.\

This part can vary depending on how you are running your game, I will assume you are using CurseForge client.
1. Open Minecraft in CurseForge.
2. Click on the `Create Custom Profile`.
3. Select your profile name, Minecraft Version `1.16.4` and current Modloader. Press `Create`.
4. Click on the custom profile you just created, there should be a drop down menu (3 dotted line) there, click on it and select `Open folder`. 
5. There should be a folder there called `mods`. If there is no folder named mods there, create it.
6. Put the jar file into the mods folder.
7. Start your game and enjoy!

Two common folder destinations for your minecraft:
* `Documents\Curse\Minecraft\Instances\<ProfileName>\mods` - CurseForge
* `C:\Users\<UserName>\AppData\Roaming\.minecraft\mods` - Vanilla Minecraft

How to setup the project
==============================

See the Forge Documentation online for more detailed instructions:
http://mcforge.readthedocs.io/en/latest/gettingstarted/

Step 1: Clone the repo.

Step 2: Open your command-line and browse to the folder where you cloned the repo.

Step 3: You're left with a choice.

If you prefer to use Eclipse:
1. Run the following command: "gradlew genEclipseRuns" (./gradlew genEclipseRuns if you are on Mac/Linux)
2. Open Eclipse, Import > Existing Gradle Project > Select Folder
   or run "gradlew eclipse" to generate the project.
   (Current Issue)
4. Open Project > Run/Debug Settings > Edit runClient and runServer > Environment
5. Edit MOD_CLASSES to show [modid]%%[Path]; 2 times rather then the generated 4.

If you prefer to use IntelliJ:
1. Open IDEA, and import project.
2. Select your build.gradle file and have it import.
3. Run the following command: "gradlew genIntellijRuns" (./gradlew genIntellijRuns if you are on Mac/Linux)
4. Refresh the Gradle Project in IDEA if required.

If at any point you are missing libraries in your IDE, or you've run into problems you can run "gradlew --refresh-dependencies" to refresh the local cache. "gradlew clean" to reset everything {this does not affect your code} and then start the processs again.

Step 4: Setup gradle to run the command ``./gradlew runClient`` or simply run it from your terminal from the root of the project.


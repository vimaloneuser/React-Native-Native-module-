/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, { useEffect } from 'react';
import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View, Button, NativeModules
} from 'react-native';

import {
  Colors,
  DebugInstructions,
  Header,
  LearnMoreLinks,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';
const { CalendarModule } = NativeModules;



const App = () => {
  const isDarkMode = useColorScheme() === 'dark';


  useEffect(() => {
    CalendarModule.createCalendarEvent('testName', 'testLocation');
  }, [])
  const backgroundStyle = {
    backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
  };

  console.log("Calendar Modules", CalendarModule);
  const NewModuleButton = () => {

    return (
      <>
        <Button
          title="Show Toast message"
          color="#841584"
          onPress={() => { CalendarModule.showToast('Vimal Patel'); }}
        />
        <Button
          title="Show snacbar"
          color="#841584"
          onPress={() => { CalendarModule.showSnacBar('Vimal Patel'); }}
        />
        <Button
          title="Go to Native screen"
          color="#841584"
          onPress={() => { CalendarModule.gotoNativeScreen(); }}
        />
        <Button
          title="Delete file"
          color="#841584"
          onPress={() => { CalendarModule.deleteFile(); }}
        />
        <Button
          title="Bottom Delete Modal"
          color="#841584"
          onPress={() => { CalendarModule.bottomModal(); }}
        />
        <Button
          title="Message Modal"
          color="#841584"
          onPress={() => { CalendarModule.message(); }}
        />
      </>
    );
  };

  return (
    <SafeAreaView style={backgroundStyle}>
      <StatusBar barStyle={isDarkMode ? 'light-content' : 'dark-content'} />
      <ScrollView
        contentInsetAdjustmentBehavior="automatic"
        style={backgroundStyle}>
        <Header />
        <View
          style={{
            backgroundColor: isDarkMode ? Colors.black : Colors.white,
          }}>

          <NewModuleButton />
        </View>
      </ScrollView>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  sectionContainer: {
    marginTop: 32,
    paddingHorizontal: 24,
  },
  sectionTitle: {
    fontSize: 24,
    fontWeight: '600',
  },
  sectionDescription: {
    marginTop: 8,
    fontSize: 18,
    fontWeight: '400',
  },
  highlight: {
    fontWeight: '700',
  },
});

export default App;

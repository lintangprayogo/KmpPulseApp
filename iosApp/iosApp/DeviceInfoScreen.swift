//
//  DeviceInfoScreen.swift
//  iosApp
//
//  Created by Lintang  on 13/04/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct DeviceInfoScreen: View {
    var body: some View {
        NavigationStack{
            DeviceInfoListView()
           .navigationTitle("Device Info")
        }
    }
}

#Preview {
    DeviceInfoScreen()
}

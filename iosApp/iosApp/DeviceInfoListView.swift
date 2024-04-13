//
//  DeviceInfoListView.swift
//  iosApp
//
//  Created by Lintang  on 13/04/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct DeviceInfoListView: View {
    
    private struct RowItem:Hashable{
        let title:String
        let subtitle:String
    }
    
    private let items:[RowItem] = {
        let platform  = Platform()
        platform.loadSystemInfo()
        
        var result:[RowItem] = [
            .init(title: "Operating System", subtitle: platform.osName),
            .init(title: "Device", subtitle: platform.deviceModel),
            .init(title: "Density", subtitle: "@\(platform.density)x")
        ]
        return result
    }()
    
    var body: some View {
        List{
            ForEach(items,id: \.self){
                item  in
                VStack(alignment: .leading){
                    Text(item.title)
                        .font(.footnote)
                        .foregroundStyle(.secondary)
                    
                    Text(item.subtitle)
                        .font(.body)
                        .foregroundStyle(.primary)
                    
                }.padding(.vertical,4)
            }
        }
    }
}

#Preview {
    DeviceInfoListView()
}
